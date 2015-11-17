package br.com.cwi.crescer;

import java.util.List;

public interface LinkableList {

    public void addFirst(String value);

    public void addLast(String value);

    public String getFirst();

    public String getLast();

    public List<String> list();

    public void removeFirst();

    public void remove(int index);

    public void add(int index, String value);

	public boolean isEmpty();


}
