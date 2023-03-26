package org.bonus.list;

//Implementare una classe StringList che si comporta come una List<String> di Java,
//ma che offre unicamente le sueguenti funzionalià (limitate rispetto ad una normale List):
//-add(String s):  aggiunge un elemento alla lista
//-size():restitutisce la dimensione della lista
//- clear(): svuota la lista
//-remove(int i): rimuove l'elemento in posizione "i"
//-get(int i): restituisce la Stringa in posizione "i"

public class StringList {
    //useremo un array elements che si dovrà comportare come una List
    private String[] elements;

    //useremo un contatore per tener traccia della dimensione effettiva dell array, escludendo i null
    private int size = 0;
    //ha senso dare un capienza massima all'array relativamente alta
    private static final int INITIAL_CAPACITY = 1000;

    public StringList() {
        elements = new String[INITIAL_CAPACITY];
    }
    public void add(String s){
        //qui gestiamo il caso in cui l'array arrivi alla dimensione massima
        if (size == elements.length){
            String[] newElements = new String[elements.length + INITIAL_CAPACITY];
            System.arraycopy(elements, 0, newElements, 0, size);
            newElements[size] = s;
        }else{
            //se non è ancora pieno, alla posizione i+1(ovvero la size) aggiungeremo il nuovo elemento nell'array
        elements[size] = s;
        }
        //aumenteremo di 1 la size dell'array
        size++;
    }

    public int size(){
        return size;
    }

    public void clear(){
        //instanziamo un nuovo array che sovrascrive il precedente;
        elements = new String[INITIAL_CAPACITY];
        //valorizziamo a 0 in modo da azzerare il contatore
        size = 0;
    }

    public void remove(int i) {
        //creiamo un nuovo array nel quale filtriamo
        String[] filteredElements = new String[size - 1];

        //individuiamo qual è l'indice dell'array nel quale l'utente vuole rimuovere l'elemento
        for(int k = 0; k < size; k++){
            //se la posizione è la stessa (k==i) non c'è problema, l'indice i è compreso negli indici di size

            //se la posizione è inferiore alla posizione dell'elemento da eliminare, cioè se la dimensione dell array è inferiore al valore  inserito dall'utente
            if (k < i) {
                //si riallineano gli indici tra i due array
                filteredElements[k] = elements[k];
                //se è superiore
            }else if(k > i){
                //si riallineano gli indici
                filteredElements[ k - 1] = elements[k];
                }
            }
        //riadeguiamo il contatore
        size --;
        //sovrascriviamo in memoria il nuovo array mancante dell'elemento eliminato
        this.elements = filteredElements;
        }

        public String get(int i){
        if (i >= size){
            throw new IndexOutOfBoundsException();
        }
        return elements[i];
        }

    }

