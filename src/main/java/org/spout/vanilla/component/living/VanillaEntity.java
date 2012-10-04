/*
 * This file is part of Vanilla.
 *
 * Copyright (c) 2011-2012, VanillaDev <http://www.spout.org/>
 * Vanilla is licensed under the SpoutDev License Version 1.
 *
 * Vanilla is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * Vanilla is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spout.vanilla.component.living;

import org.spout.api.Spout;
import org.spout.api.component.components.EntityComponent;
import org.spout.api.entity.Entity;
import org.spout.api.entity.Player;

import org.spout.vanilla.component.misc.HeadComponent;
import org.spout.vanilla.component.misc.HealthComponent;
import org.spout.vanilla.component.misc.VanillaPhysicsComponent;

public abstract class VanillaEntity extends EntityComponent {
	@Override
	public void onAttached() {
		Entity holder = getHolder();
		holder.add(HeadComponent.class);
		holder.add(HealthComponent.class);
		holder.add(VanillaPhysicsComponent.class);
	}

	@Override
	public void onTick(float dt) {
		if (getHolder().getTransform().isDirty() && !(getHolder() instanceof Player)) {
			Spout.log(toString() + " is moving. Transform: " + getHolder().getTransform().getTransform().toString());
		}
	}

	public HeadComponent getHead() {
		return getHolder().add(HeadComponent.class);
	}

	public HealthComponent getHealth() {
		return getHolder().add(HealthComponent.class);
	}

	public VanillaPhysicsComponent getPhysics() {
		return getHolder().add(VanillaPhysicsComponent.class);
	}
}
