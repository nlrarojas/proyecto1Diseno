/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.iterator;

/**
 *
 * @author nelson
 */
public interface Aggregate {
    public Iterator getIterator(int size);
}
