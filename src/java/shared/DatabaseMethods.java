/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shared;

import java.util.List;

/**
 *
 * @author Aakash
 */
public interface DatabaseMethods {

    List<Object> getAll();

    Object getById(int id);

    void insert(Object object);

    void update(int id, Object object);

    void delete(int id);
}
