/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.labti.springHibernate.controller;

import com.labti.springHibernate.app;
import com.labti.springHibernate.config.DatabarangTableModel;
import com.labti.springHibernate.model.Databarang;
import com.labti.springHibernate.view.DatapegawaiView;
import java.util.List;
import javax.swing.JOptionPane;

public class DatapegawaiController {
    private final DatapegawaiView mahasiswaView;
    private DatabarangTableModel mahasiswaTableModel;
    private List<Databarang> mahasiswas;
    
    public DatapegawaiController (DatapegawaiView mahasiswaView){
        this.mahasiswaView = mahasiswaView;
    }
    
    public void tampilData(){
        mahasiswas = app.getDatabarangService().getMahasiswas();
        mahasiswaTableModel = new DatabarangTableModel(mahasiswas);
        this.mahasiswaView.getTabel().setModel(mahasiswaTableModel);
    }
    
    public void show(){
        int index = this.mahasiswaView.getTabel().getSelectedRow();
        this.mahasiswaView.getNpm().setText(String.valueOf(
        this.mahasiswaView.getTabel().getValueAt(index, 0)));
        this.mahasiswaView.getNama().setText(String.valueOf(
        this.mahasiswaView.getTabel().getValueAt(index, 1)));
        this.mahasiswaView.getHarga().setText(String.valueOf(
        this.mahasiswaView.getTabel().getValueAt(index, 2)));
        this.mahasiswaView.getDeskripsi().setText(String.valueOf(
        this.mahasiswaView.getTabel().getValueAt(index, 3)));
    }
    
    public void clear(){
        this.mahasiswaView.getNpm().setText("");
        this.mahasiswaView.getNama().setText("");
        this.mahasiswaView.getHarga().setText("");
        this.mahasiswaView.getDeskripsi().setText("");
    }
    
    public void savePegawai(){
        Databarang mahasiswa = new Databarang();
        mahasiswa.setId(this.mahasiswaView.getNpm().getText());
        mahasiswa.setNama(this.mahasiswaView.getNama().getText());
        mahasiswa.setHarga(this.mahasiswaView.getHarga().getText());
        mahasiswa.setDeskripsi(this.mahasiswaView.getDeskripsi().getText());
        app.getDatabarangService().save(mahasiswa);
        JOptionPane.showMessageDialog(null, "Data Berhasil di simpan", "info",
                JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }
    
    public void updateMahasiswa(){
        Databarang mahasiswa = new Databarang();
        mahasiswa.setId(this.mahasiswaView.getNpm().getText());
        mahasiswa.setNama(this.mahasiswaView.getNama().getText());
        mahasiswa.setHarga(this.mahasiswaView.getHarga().getText());
        mahasiswa.setDeskripsi(this.mahasiswaView.getDeskripsi().getText());
        app.getDatabarangService().update(mahasiswa);
        JOptionPane.showMessageDialog(null, "Data berhasil di Edit", "info",
                JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }
    
    public void deleteMahasiswa(){
        if(this.mahasiswaView.getNpm().getText() == null){
            JOptionPane.showMessageDialog(null, "mahasiswa belum dipilih","error",JOptionPane.ERROR_MESSAGE);
        }else{
            Databarang mahasiswa = new Databarang();
            mahasiswa.setId(this.mahasiswaView.getNpm().getText());
            int pilih = JOptionPane.showConfirmDialog(null,"Apakah data ingin dihapus ?", "Warning",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (pilih == JOptionPane.YES_OPTION){
                app.getDatabarangService().delete(mahasiswa);
                JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus","info",JOptionPane.INFORMATION_MESSAGE);
                clear();
                tampilData();
            }
        }
    }
}