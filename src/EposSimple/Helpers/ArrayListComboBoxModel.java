/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EposSimple.Helpers;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author tg
 */

public class ArrayListComboBoxModel extends AbstractListModel implements ComboBoxModel {
  private Object selectedItem;

  private final ArrayList anArrayList;

  public ArrayListComboBoxModel(ArrayList arrayList) {
    anArrayList = arrayList;
  }

  @Override
  public Object getSelectedItem() {
    return selectedItem;
  }

  @Override
  public void setSelectedItem(Object newValue) {
    selectedItem = newValue;
  }

  @Override
  public int getSize() {
    return anArrayList.size();
  }

  @Override
  public Object getElementAt(int i) {
    return anArrayList.get(i);
  }

}
