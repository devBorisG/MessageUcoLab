package co.edu.uco.infrastructure.adapter.secondary.repository.data;

public interface DataMapper <D, A> {
    D assemblerData(A model);
    A assemblerModel(D data);
}