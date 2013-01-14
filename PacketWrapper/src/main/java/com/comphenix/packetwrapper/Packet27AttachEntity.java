/*
 *  PacketWrapper - Contains wrappers for each packet in Minecraft.
 *  Copyright (C) 2012 Kristian S. Stangeland
 *
 *  This program is free software; you can redistribute it and/or modify it under the terms of the 
 *  GNU Lesser General Public License as published by the Free Software Foundation; either version 2 of 
 *  the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 *  See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with this program; 
 *  if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 
 *  02111-1307 USA
 */

package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class Packet27AttachEntity extends AbstractPacket {
    public static final int ID = 39;
    
    public Packet27AttachEntity() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public Packet27AttachEntity(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve the player entity ID being attached.
     * @return The current Entity ID
    */
    public int getEntityId() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set the player entity ID being attached.
     * @param value - new value.
    */
    public void setEntityId(int value) {
        handle.getIntegers().write(0, value);
    }

    /**
     * Retrieve the entity being attached.
     * @param world - the current world of the entity.
     * @return The entity.
     */
    public Entity getEntity(World world) {
    	return handle.getEntityModifier(world).read(0);
    }

    /**
     * Retrieve the entity being attached.
     * @param event - the packet event.
     * @return The entity.
     */
    public Entity getEntity(PacketEvent event) {
    	return getEntity(event.getPlayer().getWorld());
    }
    
    /**
     * Retrieve the vehicle entity ID attached to (-1 for unattaching).
     * @return The current Vehicle ID
    */
    public int getVehicleId() {
        return handle.getIntegers().read(1);
    }
    
    /**
     * Retrieve the vehicle entity attached to (NULL for unattaching).
     * @param world - the current world of the entity.
     * @return The vehicle.
     */
    public Entity getVehicle(World world) {
    	return handle.getEntityModifier(world).read(1);
    }

    /**
     * Retrieve the vehicle entity attached to (NULL for unattaching).
     * @param event - the packet event.
     * @return The vehicle.
     */
    public Entity getVehicle(PacketEvent event) {
    	return getVehicle(event.getPlayer().getWorld());
    }
    
    /**
     * Set the vehicle entity ID attached to (-1 for unattaching).
     * @param value - new value.
    */
    public void setVehicleId(int value) {
        handle.getIntegers().write(1, value);
    }
}

