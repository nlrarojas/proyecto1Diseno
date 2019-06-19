/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.character.ICharacterDecorator;
import java.io.Serializable;

/**
 *
 * @author Charlie
 */
public interface IObservableCharacter extends Serializable{
    public void notifyObservers();
    public void addObserver(ICharacterObserver observer);
    public void removeObserver(ICharacterObserver observer);
}
