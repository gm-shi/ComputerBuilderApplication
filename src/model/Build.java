package model;

import java.util.List;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Build {

	private ObservableList<Part> parts;
	public ObservableList<Part> getParts() {
		return this.parts;
	}
	private DoubleProperty total = new SimpleDoubleProperty();

	public Build() {

		parts = FXCollections.observableArrayList();
		parts.addListener(new ListChangeListener<Part>() {
			@Override
			public void onChanged(Change<? extends Part> c) {
				total.set(totalPrice());
			}
		});

	}

	public void addPart(Part part) {
		parts.add(part);
	}

	public boolean isValid() {
		return hasPartOfType("cpu") && hasPartOfType("motherboard") && hasPartOfType("memory") && hasPartOfType("case")
				&& hasPartOfType("storage");
	}
	public ReadOnlyDoubleProperty totalProperty() {
		return total;
	}
	public final double getTotal() {
		return total.get();
	}

	public double totalPrice() {

		double sum = 0.0;

		for (Part p : parts)
			sum += p.getPrice();

		return sum;
	}

	public boolean hasPartOfType(String type) {
		for (Part p : parts) {
			if (p.hasType(type))
				return true;
		}

		return false;
	}

	public void remove(Part p) {
		this.parts.remove(p);
	}

	public void remove(List<Part> selectedItems) {

		this.parts.removeAll(selectedItems);

	}

	public void addParts(List<Part> selectedItems) {

		this.parts.addAll(selectedItems);

	}

}
