package flowapowa.application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Recipe implements Iterable<Element> {
    private final List<Element> elements;

    public Recipe() {
        this.elements = new ArrayList<>();
    }

    public Recipe(String rawRecipe) {
        this.elements = new ArrayList<>();
        String[] lines = rawRecipe.split(";");

        for (String line :
                lines) {
            String[] parts = line.split(":");
            this.add(parts[0], Integer.parseInt(parts[1]));
        }
    }

    public void add(String flower, int quantity) {
        Element element = new Element(flower, quantity);

        elements.add(element);
    }

    @Override
    public Iterator<Element> iterator() {
        return elements.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe elements1 = (Recipe) o;

        return elements.equals(elements1.elements);
    }

    @Override
    public int hashCode() {
        return elements.hashCode();
    }

}
