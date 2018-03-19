/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sokoban;

/**
 *
 * @author Cas_Ros
 */
public class NoTileException extends Exception {
    NoTileException(String no_tile_at_these_coordinates) {
        System.out.println(no_tile_at_these_coordinates);
    }
}