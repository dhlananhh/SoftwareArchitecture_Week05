package iuh.fit.se.taskmanagement;

import java.util.ArrayList;
import java.util.List;

public class Task {
	private String status;
    private List<Observer> observers = new ArrayList<>();

    public Task(String initialStatus) {
        this.status = initialStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String newStatus) {
        if (!this.status.equals(newStatus)) {
            this.status = newStatus;
            notifyObservers();
        }
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
