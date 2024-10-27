package dev.sapphic.couplings;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record ConfigSyncPacket(int couplings) implements CustomPacketPayload {
    public static final ResourceLocation IDENTIFIER = ResourceLocation.fromNamespaceAndPath("couplings", "config_sync");
    public static final CustomPacketPayload.Type<ConfigSyncPacket> TYPE = new CustomPacketPayload.Type<>(IDENTIFIER);

    public static final StreamCodec<RegistryFriendlyByteBuf, ConfigSyncPacket> CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, ConfigSyncPacket::couplings,
            ConfigSyncPacket::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}

