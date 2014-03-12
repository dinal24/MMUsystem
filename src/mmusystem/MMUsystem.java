/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mmusystem;

/**
 *
 * @author Dinal
 */



class MemoryManagementUnit {

    private static RAM myram = new RAM();;
    private static Pagetable pageTable = new Pagetable();
    
    public static void main(String[] args) {
       MemoryManagementUnit.pageTable.Decode(myram,"12341234");
        
    }
    public MemoryManagementUnit() {
        
    }

    
}


class Pagetable {

    boolean[] presencebit = new boolean[65536];
    int[] pageTable = new int[65536];

    public Pagetable() {
        for (int i = 0; i <65536 ; i++) {
            presencebit[i] = true;
            pageTable[i] = 0;
        }
        
    }

    public String Decode(RAM myRam,String virtualaddress) {
        int page = Integer.parseInt(virtualaddress.substring(0, 4));
        int word = Integer.parseInt(virtualaddress.substring(4, 8));

        if (presencebit[page] != false) {
            return myRam.getWord(page, word);
        } else {
            return "Page fault";
        }
    }
}

class RAM {

    private Block blocks[] = new Block[16];

    public RAM() {
        for (int i = 0; i < 16; i++) {
            blocks[i] = new Block("sample data @" + i );
        }
    }

    
    public String getWord(int blocknumber, int address) {
        return blocks[blocknumber].getData(address);
    }
}

class Block {

    private String data[] = new String[65536];

    public Block(String value) {
        for (int i = 0; i < 65536; i++) {
            data[i] = value;
        }
    }

    public String getData(int address) {
        return data[address];
    }

    public void setData(String[] data) {
        this.data = data;
    }
    
    
}
