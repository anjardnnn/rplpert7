/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labti.springHibernate.config;

import com.labti.springHibernate.model.Databarang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DatabarangTableModel extends AbstractTableModel {
    
    private List<Databarang> mahasiswas = new ArrayList<>();
    private final String HEADER[] = {"ID","Nama","HARGA","DESKRIPSI"};
    
    public DatabarangTableModel(List<Databarang> mahasiswas){
        this.mahasiswas = mahasiswas;
    }
    
    @Override
    public int getRowCount(){
        return mahasiswas.size();
    }
    
    @Override
    public int getColumnCount(){
        return HEADER.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return HEADER[columnIndex];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Databarang mahasiswa = mahasiswas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return mahasiswa.getId();
            case 1:
                return mahasiswa.getNama();
            case 2:
                return mahasiswa.getHarga();
            case 3:
                return mahasiswa.getDeskripsi();
            default:
                return null;
        }
    }
}