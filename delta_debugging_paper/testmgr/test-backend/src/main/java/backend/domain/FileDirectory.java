package backend.domain;

import java.util.ArrayList;

public class FileDirectory extends FileNode {

    ArrayList<FileNode> pdts = new ArrayList<FileNode>();

    public FileDirectory(){

    }

    public ArrayList<FileNode> getProducts() {
        return pdts;
    }

    public void setProducts(ArrayList<FileNode> pdts) {
        this.pdts = pdts;
    }

    public void addProduct(FileNode fn){
        pdts.add(fn);
    }

}
