import java.util.Arrays;

public class Pharmacy {
    private  String name;
    private String address;
    Medicines[]medicines;
    Worker[]workers;

    public Pharmacy(String name, String address, Medicines[] medicines, Worker[] workers) {
        this.name = name;
        this.address = address;
        this.medicines = medicines;
        this.workers = workers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Medicines[] getMedicines() {
        return medicines;
    }

    public void setMedicines(Medicines[] medicines) {
        this.medicines = medicines;
    }

    public Worker[] getWorkers() {
        return workers;
    }

    public void setWorkers(Worker[] workers) {
        this.workers = workers;
    }
    String updateMedicinePrice(String medicineName, int newPrice){
        for (int i = 0; i < medicines.length; i++) {
           if(medicines[i].getName().equalsIgnoreCase(medicineName)){
              medicines[i].setPrice(newPrice);
              return "New price "+ medicines[i];
            }
        }
              return null;
    }
    String deleteMedicineByName(String MedicineName){
        int index = 0;
        for (int i = 0; i < medicines.length; i++) {
            if (medicines[i].getName().equalsIgnoreCase(MedicineName)) {
                index = i;
            }
        }
        if (index==0) {
            return " " + Arrays.toString(medicines);
        }
        Medicines [] newMedicines = new Medicines[medicines.length-1];
        if (index > 0){
            System.arraycopy(medicines,0,newMedicines,0,index);
        }
        if (index < medicines.length-1){
            System.arraycopy(medicines,index+1,newMedicines,index,medicines.length-index-1);
        }
        return " "+Arrays.toString(newMedicines);
    }

    String deleteWorkerByName(String workerName){
        for (int i = 0; i < workers.length; i++) {
            if (workers[i].getName().equalsIgnoreCase(workerName)){
                for (int j = i; j < workers.length-1; j++) {
                    workers[j]=workers[j+1];
                }
                workers[workers.length-1] =null;
                return "worker was deleted";
            }
        }
        return "worker was not deleted";
    }
    @Override
    public String toString() {
        return "Pharmacy{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", medicines=" + Arrays.toString(medicines) +
                ", workers=" + Arrays.toString(workers) +
                '}';
    }
}
