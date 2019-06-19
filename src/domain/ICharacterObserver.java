/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.character.ICharacterDecorator;

/**
 *
 * @author Charlie
 */
public interface ICharacterObserver {
    public void notify(ICharacterDecorator character);
}
