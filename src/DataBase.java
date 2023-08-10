import java.util.Arrays;
import java.util.Scanner;

public class DataBase {
    private Pharmacy[] pharmacies;

    public DataBase(Pharmacy[] pharmacies) {
        this.pharmacies = pharmacies;
    }

    public Pharmacy[] getPharmacies() {
        return pharmacies;
    }

    public void setPharmacies(Pharmacy[] pharmacies) {
        this.pharmacies = pharmacies;
    }

    Medicines[] getAllMedicinesByPharmacyName(String pharmacyName) {
        for (int i = 0; i < pharmacies.length; i++) {
            if (pharmacies[i].getName().equalsIgnoreCase(pharmacyName)) {
                return pharmacies[i].getMedicines();
            }
        }
        return null;
    }

    Worker[] getAllSortedWorkersNameByPharmacyAddress(String address) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < pharmacies.length; i++) {
            if (pharmacies[i].getAddress().equalsIgnoreCase(address)) {
                return pharmacies[i].getWorkers();
            }
        }
        return null;
    }

    String addMedicinesToPharmacy(String pharmacyName, Medicines medicines) {
            for (int i = 0; i < pharmacies.length; i++) {
                if (pharmacies[i].getName().equalsIgnoreCase(pharmacyName)) {
                    Medicines[] oldMedicines = pharmacies[i].getMedicines();
                    for (int j = 0; j < oldMedicines.length; j++) {
                        if (oldMedicines[j].getName().equalsIgnoreCase(medicines.getName())) {
                            return "This medicine already exists";
                        }
                    }
                    Medicines[] newMedicines = new Medicines[oldMedicines.length + 1];
                    for (int j = 0; j < oldMedicines.length; j++) {
                        newMedicines[j] = oldMedicines[j];
                    }
                    newMedicines[oldMedicines.length] = medicines;
                    pharmacies[i].setMedicines(newMedicines);
                    return "Medicine added: " + Arrays.toString(newMedicines);
                }
            }
            return "Pharmacy not found";
        }

    Pharmacy getPharmacyByWorkerName(String workerName){
        for (int i = 0; i < pharmacies[i].getWorkers().length; i++) {
            if (pharmacies[i].getWorkers()[i].getName().equalsIgnoreCase(workerName)){
                return pharmacies[i];
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return "DataBase{" +
                "pharmacies=" + Arrays.toString(pharmacies) +
                '}';
    }
}
