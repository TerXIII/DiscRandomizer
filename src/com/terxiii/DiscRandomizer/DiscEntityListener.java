package com.terxiii.DiscRandomizer;

import java.util.List;

import org.bukkit.entity.Creeper;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.inventory.ItemStack;

public class DiscEntityListener extends EntityListener {
	
	public boolean isEnabled = false;
	
	public void onEntityDeath(EntityDeathEvent e)
	{
		if(isEnabled)
		{
			if(e.getEntity() instanceof Creeper)
			{
				List<ItemStack> di = e.getDrops();
				ItemStack ti;
				for(int count=0;count<di.size();count++)
				{
					ti = di.get(count);
					DiscRandomizer.swapDisc(ti);
				}
			}
		}
	}
}
