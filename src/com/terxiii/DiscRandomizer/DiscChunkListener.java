package com.terxiii.DiscRandomizer;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.event.world.WorldListener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class DiscChunkListener extends WorldListener {
	
	public boolean isEnabled = false;
	
	public void onChunkPopulate(ChunkPopulateEvent e)
	{
		if(isEnabled)
		{
			BlockState[] bsts = e.getChunk().getTileEntities();
			Chest swpc;
			Inventory swpi;
			
			for(int count=0;count<bsts.length;count++)
			{
				if(bsts[count] instanceof Chest)
				{
					swpc = (Chest)bsts[count];
					swpi = swpc.getInventory();
					
					ArrayList<ItemStack> records = new ArrayList<ItemStack>();
					
					records = DiscRandomizer.chestSearch(swpi, Material.GREEN_RECORD);
					records.addAll(DiscRandomizer.chestSearch(swpi, Material.GOLD_RECORD));
					
					for(int ch=0;ch<records.size();ch++)
					{
						if(ch==0)
						{
							DiscRandomizer.log.info("Chest has records in it!");
						}
						DiscRandomizer.swapDisc(records.get(ch));
					}
				}
			}
		}
	}
}
