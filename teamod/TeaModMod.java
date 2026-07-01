package net.mcreator.teamod;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.util.Tuple;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.teamod.init.TeaModModTabs;
import net.mcreator.teamod.init.TeaModModPotions;
import net.mcreator.teamod.init.TeaModModMobEffects;
import net.mcreator.teamod.init.TeaModModMenus;
import net.mcreator.teamod.init.TeaModModItems;
import net.mcreator.teamod.init.TeaModModFluids;
import net.mcreator.teamod.init.TeaModModFluidTypes;
import net.mcreator.teamod.init.TeaModModEntities;
import net.mcreator.teamod.init.TeaModModBlocks;
import net.mcreator.teamod.init.TeaModModBlockEntities;
import net.mcreator.teamod.init.TeaModModAttributes;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;

@Mod("tea_mod")
public class TeaModMod {
	public static final Logger LOGGER = LogManager.getLogger(TeaModMod.class);
	public static final String MODID = "tea_mod";

	public TeaModMod(IEventBus modEventBus) {
		// Start of user code block mod constructor
		// End of user code block mod constructor
		NeoForge.EVENT_BUS.register(this);
		modEventBus.addListener(this::registerNetworking);

		TeaModModBlocks.REGISTRY.register(modEventBus);
		TeaModModBlockEntities.REGISTRY.register(modEventBus);
		TeaModModItems.REGISTRY.register(modEventBus);
		TeaModModEntities.REGISTRY.register(modEventBus);
		TeaModModTabs.REGISTRY.register(modEventBus);

		TeaModModPotions.REGISTRY.register(modEventBus);
		TeaModModMobEffects.REGISTRY.register(modEventBus);
		TeaModModMenus.REGISTRY.register(modEventBus);

		TeaModModFluids.REGISTRY.register(modEventBus);
		TeaModModFluidTypes.REGISTRY.register(modEventBus);
		TeaModModAttributes.REGISTRY.register(modEventBus);
		// Start of user code block mod init
		// End of user code block mod init
	}

	// Start of user code block mod methods
	// End of user code block mod methods
	private static boolean networkingRegistered = false;
	private static final Map<CustomPacketPayload.Type<?>, NetworkMessage<?>> MESSAGES = new HashMap<>();

	private record NetworkMessage<T extends CustomPacketPayload>(StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
	}

	public static <T extends CustomPacketPayload> void addNetworkMessage(CustomPacketPayload.Type<T> id, StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
		if (networkingRegistered)
			throw new IllegalStateException("Cannot register new network messages after networking has been registered");
		MESSAGES.put(id, new NetworkMessage<>(reader, handler));
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	private void registerNetworking(final RegisterPayloadHandlersEvent event) {
		final PayloadRegistrar registrar = event.registrar(MODID);
		MESSAGES.forEach((id, networkMessage) -> registrar.playBidirectional(id, ((NetworkMessage) networkMessage).reader(), ((NetworkMessage) networkMessage).handler()));
		networkingRegistered = true;
	}

	private static final Collection<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workQueue.add(new Tuple<>(action, tick));
	}

	@SubscribeEvent
	public void tick(ServerTickEvent.Post event) {
		List<Tuple<Runnable, Integer>> actions = new ArrayList<>();
		workQueue.forEach(work -> {
			work.setB(work.getB() - 1);
			if (work.getB() == 0)
				actions.add(work);
		});
		actions.forEach(e -> e.getA().run());
		workQueue.removeAll(actions);
	}
}