/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Charlie
 */
public interface IPrototype {
    public IPrototype clone();
    public IPrototype deepClone();
}
