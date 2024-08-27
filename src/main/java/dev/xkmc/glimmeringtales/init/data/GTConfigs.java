package dev.xkmc.glimmeringtales.init.data;

import dev.xkmc.glimmeringtales.init.GlimmeringTales;
import dev.xkmc.l2core.util.ConfigInit;
import net.neoforged.neoforge.common.ModConfigSpec;

public class GTConfigs {

	public static class Client extends ConfigInit {

		public final ModConfigSpec.IntValue resonatorSearchRadius;
		public final ModConfigSpec.IntValue resonatorSearchTrialsPerTick;

		public Client(Builder builder) {
			markL2();
			builder.push("resonator", "Resonator properties");
			resonatorSearchRadius = builder.text("Amethyst Resonator search radius")
					.defineInRange("resonatorSearchRadius", 64, 16, 128);
			resonatorSearchTrialsPerTick = builder.text("Amethyst Resonator search trials per tick")
					.defineInRange("resonatorSearchTrialsPerTick", 500, 16, 10000);
			builder.pop();

		}
	}

	public static class Server extends ConfigInit {

		public final ModConfigSpec.IntValue crystalOfFlameRequirement;
		public final ModConfigSpec.IntValue crystalOfWinterstormRequirement;
		public final ModConfigSpec.IntValue wandInteractionDistance;

		public Server(Builder builder) {
			markL2();
			wandInteractionDistance = builder
					.text("Wand interaction range")
					.defineInRange("wandInteractionDistance", 24, 4, 64);
			builder.push("materials", "Material properties");
			crystalOfFlameRequirement = builder
					.text("Crystal of Flame: Lava consumption")
					.defineInRange("crystalOfFlameRequirement", 64, 1, 1000);
			crystalOfWinterstormRequirement = builder
					.text("Crystal of Winterstorm: Powder Snow consumption")
					.defineInRange("crystalOfWinterstormRequirement", 64, 1, 1000);
			builder.pop();
		}
	}

	public static final Client CLIENT = GlimmeringTales.REGISTRATE.registerClient(Client::new);
	public static final Server SERVER = GlimmeringTales.REGISTRATE.registerSynced(Server::new);

}
