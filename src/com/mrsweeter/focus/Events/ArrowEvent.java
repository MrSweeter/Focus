package com.mrsweeter.focus.Events;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ArrowEvent implements Listener {

	@EventHandler
	public void onProjectileHit(ProjectileHitEvent e) {
		
		if (e.getHitBlock() != null)	{
			if ((e.getEntityType() == EntityType.ARROW)
					|| (e.getEntityType() == EntityType.SPECTRAL_ARROW)
					|| (e.getEntityType() == EntityType.TIPPED_ARROW))	{
				e.getEntity().remove();
			}
		}
	}
}
