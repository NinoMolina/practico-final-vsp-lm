package com.vates.vsp.commons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.model.DataModel;
import javax.faces.model.DataModelEvent;
import javax.faces.model.DataModelListener;

public class ListDataModel<T> extends DataModel {

	// ------------------------------------------------------------ Constructors

	/**
	 * <p>
	 * Construct a new {@link ListDataModel} with no specified wrapped data.
	 * </p>
	 */
	public ListDataModel() {
		this(new ArrayList<T>());

	}

	public ListDataModel(Collection<T> set) {
		this(new ArrayList<T>(set));
	}

	/**
	 * <p>
	 * Construct a new {@link ListDataModel} wrapping the specified list.
	 * </p>
	 * 
	 * @param list
	 *            List to be wrapped (if any)
	 */
	public ListDataModel(List<T> list) {

		super();
		setWrappedData(list);

	}

	// ------------------------------------------------------ Instance Variables

	// The current row index (zero relative)
	private int index = -1;

	// The list we are wrapping
	private List<T> list;

	// -------------------------------------------------------------- Properties

	/**
	 * <p>
	 * Return <code>true</code> if there is <code>wrappedData</code> available,
	 * and the current value of <code>rowIndex</code> is greater than or equal
	 * to zero, and less than the size of the list. Otherwise, return
	 * <code>false</code>.
	 * </p>
	 * 
	 * @throws FacesException
	 *             if an error occurs getting the row availability
	 */
	public boolean isRowAvailable() {

		if (list == null) {
			return (false);
		} else if ((index >= 0) && (index < list.size())) {
			return (true);
		} else {
			return (false);
		}

	}

	/**
	 * <p>
	 * If there is <code>wrappedData</code> available, return the length of the
	 * list. If no <code>wrappedData</code> is available, return -1.
	 * </p>
	 * 
	 * @throws FacesException
	 *             if an error occurs getting the row count
	 */
	public int getRowCount() {

		if (list == null) {
			return (-1);
		}
		return (list.size());

	}

	/**
	 * <p>
	 * If row data is available, return the array element at the index specified
	 * by <code>rowIndex</code>. If no wrapped data is available, return
	 * <code>null</code>.
	 * </p>
	 * 
	 * @throws FacesException
	 *             if an error occurs getting the row data
	 * @throws IllegalArgumentException
	 *             if now row data is available at the currently specified row
	 *             index
	 */
	public T getRowData() {

		if (list == null) {
			return (null);
		} else if (!isRowAvailable()) {
			throw new IllegalArgumentException("No Row Available");
		} else {
			return (list.get(index));
		}

	}

	/**
	 * @throws FacesException
	 *             {@inheritDoc}
	 */
	public int getRowIndex() {

		return (index);

	}

	/**
	 * @throws FacesException
	 *             {@inheritDoc}
	 * @throws IllegalArgumentException
	 *             {@inheritDoc}
	 */
	public void setRowIndex(int rowIndex) {

		if (rowIndex < -1) {
			throw new IllegalArgumentException();
		}
		int old = index;
		index = rowIndex;
		if (list == null) {
			return;
		}
		DataModelListener[] listeners = getDataModelListeners();
		if ((old != index) && (listeners != null)) {
			Object rowData = null;
			if (isRowAvailable()) {
				rowData = getRowData();
			}
			DataModelEvent event = new DataModelEvent(this, index, rowData);
			int n = listeners.length;
			for (int i = 0; i < n; i++) {
				if (null != listeners[i]) {
					listeners[i].rowSelected(event);
				}
			}
		}

	}

	public List<T> getWrappedData() {
		return (this.list);
	}

	/**
	 * @throws ClassCastException
	 *             if <code>data</code> is non-<code>null</code> and is not a
	 *             <code>List</code>
	 */
	@SuppressWarnings("unchecked")
	public void setWrappedData(Object data) {

		if (data == null) {
			list = null;
			setRowIndex(-1);
		} else {
			list = (List<T>) data;
			index = -1;
			setRowIndex(0);
		}
	}

}
