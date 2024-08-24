package dev.xkmc.glimmeringtales.init.data.spell;

import dev.xkmc.glimmeringtales.init.data.spell.advanced.FlameSpells;
import dev.xkmc.glimmeringtales.init.data.spell.advanced.SnowSpells;
import dev.xkmc.glimmeringtales.init.data.spell.earth.*;
import dev.xkmc.glimmeringtales.init.data.spell.flame.MagmaSpells;
import dev.xkmc.glimmeringtales.init.data.spell.life.*;
import dev.xkmc.glimmeringtales.init.data.spell.thunder.ThunderSpells;

import java.util.List;

public class NatureSpellGenRegistry {

	public static final List<NatureSpellEntry> LIST = List.of(
			new DripstoneSpells(), // 1010
			new ClaySpells(), // 1020
			AmethystSpells.BUILDER, // 1030
			new SandSpells(), // 1040
			new QuartzSpells(), // 1050
			new VinesSpell(), // 1050
			new HaySpell(),
			new CactusSpell(),
			new BambooSpell(),
			new FlowerSpell(),
			new GravelSpells(), // 1060
			new StoneSpells(),
			new MagmaSpells(),
			new ThunderSpells(),
			FlameSpells.HM, FlameSpells.LB,
			SnowSpells.WS, SnowSpells.ST
	);

}
