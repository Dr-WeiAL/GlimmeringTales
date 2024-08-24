package dev.xkmc.glimmeringtales.init.data.spell;

import dev.xkmc.glimmeringtales.init.data.spell.advanced.FlameSpells;
import dev.xkmc.glimmeringtales.init.data.spell.advanced.SnowSpells;
import dev.xkmc.glimmeringtales.init.data.spell.earth.*;
import dev.xkmc.glimmeringtales.init.data.spell.flame.MagmaSpells;
import dev.xkmc.glimmeringtales.init.data.spell.life.*;
import dev.xkmc.glimmeringtales.init.data.spell.thunder.ThunderSpells;

import java.util.ArrayList;
import java.util.List;

public class NatureSpellGenRegistry {

	public static final List<NatureSpellEntry> LIST = new ArrayList<>();

	static {

		// earth
		LIST.addAll(List.of(
				DripstoneSpells.BUILDER, // 1010
				ClaySpells.BUILDER, // 1020
				AmethystSpells.BUILDER, // 1030
				new SandSpells(), // 1040
				new QuartzSpells(), // 1050
				new GravelSpells(), // 1060
				new StoneSpells()
		));

		// vine
		LIST.addAll(List.of(
				new VinesSpell(), // 1050
				new HaySpell(),
				new CactusSpell(),
				new BambooSpell(),
				new FlowerSpell()
		));

		// others
		LIST.addAll(List.of(
				new MagmaSpells(),
				new ThunderSpells()
		));

		// advanced
		LIST.addAll(List.of(
				FlameSpells.HM, FlameSpells.LB,
				SnowSpells.WS, SnowSpells.ST
		));
	}

}
