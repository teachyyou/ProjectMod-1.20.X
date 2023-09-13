package net.igor.projectmod.item;

import net.igor.projectmod.ProjectMod;
import net.igor.projectmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProjectMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PROJECT_TAB = CREATIVE_MODE_TABS.register( "project_tab",
            () -> CreativeModeTab.builder().icon(()->new ItemStack(ModItems.DRYROOT.get())).title(Component.translatable( "creativetab.project_tab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept((ModItems.DRYROOT.get()));
                        pOutput.accept(ModBlocks.ROOT_BLOCK.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
