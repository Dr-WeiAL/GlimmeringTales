package dev.xkmc.glimmeringtales.content.item.rune;

import dev.xkmc.glimmeringtales.content.core.spell.RuneBlock;
import dev.xkmc.glimmeringtales.content.core.spell.SpellInfo;
import dev.xkmc.glimmeringtales.content.item.wand.SpellCastContext;
import dev.xkmc.glimmeringtales.init.reg.GTRegistries;
import net.minecraft.core.RegistryAccess;

import java.util.Optional;

public class BlockRuneItem extends BaseRuneItem implements IBlockSpellItem {

	public BlockRuneItem(Properties properties) {
		super(properties);
	}

	public Optional<RuneBlock> getSpell(RegistryAccess access) {
		return Optional.ofNullable(GTRegistries.RUNE_BLOCK.get(access, builtInRegistryHolder()));
	}

	public SpellInfo getSpellInfo(RegistryAccess access) {
		return SpellInfo.ofRune(getSpell(access).orElse(null));
	}

	@Override
	public boolean castSpell(SpellCastContext user) {
		var opt = getSpell(user.level().registryAccess());
		if (opt.isEmpty()) return false;
		var spell = opt.get();
		var ctx = BlockSpellContext.entitySpellContext(user.user(), entityTrace(), spell);
		if (ctx == null) return false;
		return execute(spell.spell().value(), ctx.ctx(), user, DefaultAffinity.INS, 0, false);
	}

}
