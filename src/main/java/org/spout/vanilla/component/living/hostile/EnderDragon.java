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
package org.spout.vanilla.component.living.hostile;

import javax.vecmath.Vector3f;

import com.bulletphysics.collision.shapes.BoxShape;
import com.bulletphysics.dynamics.RigidBody;

import org.spout.api.math.MathHelper;

import org.spout.vanilla.VanillaPlugin;
import org.spout.vanilla.component.living.Hostile;
import org.spout.vanilla.component.living.VanillaEntity;
import org.spout.vanilla.component.misc.VanillaPhysicsComponent;
import org.spout.vanilla.protocol.entity.living.EnderDragonEntityProtocol;

/**
 * A component that identifies the entity as an EnderDragon.
 */
public class EnderDragon extends VanillaEntity implements Hostile {
	@Override
	public void onAttached() {
		super.onAttached();
		getOwner().getNetwork().setEntityProtocol(VanillaPlugin.VANILLA_PROTOCOL_ID, new EnderDragonEntityProtocol());
		VanillaPhysicsComponent physics = getOwner().add(VanillaPhysicsComponent.class);
		physics.setCollisionShape(new BoxShape(MathHelper.toVector3f(10f, 5f, 10f)));
		physics.setMass(50f);
		Vector3f inertia = new Vector3f();
		physics.getCollisionShape().calculateLocalInertia(physics.getMass(), inertia);
		physics.setCollisionObject(new RigidBody(physics.getMass(), physics.getMotionState(), physics.getCollisionShape(), inertia));
	}
}
