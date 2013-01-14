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

import com.comphenix.protocol.events.PacketContainer;

public class Packet08UpdateHealth extends AbstractPacket {
    public static final int ID = 8;
    
    public Packet08UpdateHealth() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet08UpdateHealth(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the health of the current player.
     * <p>
     * Value zero or less is dead. 20 is the full HP.
     * @return The current Health
    */
    public short getHealth() {
        return handle.getIntegers().read(0).shortValue();
    }
    
    /**
     * Set the health of the current player.
     * <p>
     * Value zero or less is dead. 20 is the full HP.
     * @param value - new value.
    */
    public void setHealth(short value) {
        handle.getIntegers().write(0, (int) value);
    }
    
    /**
     * Retrieve the food level.
     * <p>
     * Valid range: 0 - 20.
     * @return The current food level.
    */
    public short getFood() {
        return handle.getIntegers().read(1).shortValue();
    }
    
    /**
     * Set the food level.
     * <p>
     * Valid range: 0 - 20.
     * @param value - new value.
    */
    public void setFood(short value) {
        handle.getIntegers().write(1, (int) value);
    }
    
    /**
     * Retrieve the food saturation.
     * <p>
     * Varies from 0.0 to 5.0 in integer increments.
     * @return The current Food Saturation
    */
    public float getFoodSaturation() {
        return handle.getFloat().read(0);
    }
    
    /**
     * Set the food saturation.
     * <p>
     * Varies from 0.0 to 5.0 in integer increments.
     * @param value - new value.
    */
    public void setFoodSaturation(float value) {
        handle.getFloat().write(0, value);
    }
}

