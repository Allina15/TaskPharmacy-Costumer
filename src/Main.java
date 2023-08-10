import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Medicines medicines1 = new Medicines("Парацетамол",30,20);
        Medicines medicines2 = new Medicines("цитрамон",45,30);
        Medicines medicines3 = new Medicines("Антигриппин",35,15);
        Medicines medicines4 = new Medicines("Но-Шпа",60,10);
        Medicines medicines5 = new Medicines("Кетанол",50,21);
        Medicines medicines6 = new Medicines("Тайлол-Хот",38,14);
        Medicines medicines7 = new Medicines("Ибупрофен",100,23);
        Medicines medicines8 = new Medicines("Аммоксоцилин",55,32);
        Medicines medicines9 = new Medicines("Нол грипп",60,12);
        Medicines [] mediciness1 = {medicines1,medicines2};
        Medicines [] mediciness2 = {medicines4,medicines5,medicines6};
        Medicines [] mediciness3 = {medicines7,medicines8,medicines9};

        Worker worker1 = new Worker("zalkar",20,"Zalkar@mail.com");
        Worker worker2 = new Worker("Bekzat",23,"Bekzat@mail.com");
        Worker worker3 = new Worker("Nurtilek",25,"Nurti@mail.com");
        Worker worker4 = new Worker("Muha",34,"Muha@mail.com");
        Worker worker5 = new Worker("Tilek",42,"Tilya@mail.com");
        Worker worker6 = new Worker("Kandybek",30,"Koni@mail.com");
        Worker [] workers1 = {worker1,worker2};
        Worker [] workers2 = {worker3,worker4};
        Worker [] workers3 = {worker5,worker6};

        Pharmacy pharmacy1 = new Pharmacy("Neman","chuy 123",mediciness1,workers1);
        Pharmacy pharmacy2 = new Pharmacy("SayanPharm","Ch.Aitmatov 69",mediciness2,workers2);
        Pharmacy pharmacy3 = new Pharmacy("Aibolit","Kiev 25",mediciness3,workers3);
        Pharmacy [] pharmacies = {pharmacy1,pharmacy2,pharmacy3};

        Scanner scanner = new Scanner(System.in);
        DataBase dataBase = new DataBase(pharmacies);
        System.out.println(Arrays.toString(dataBase.getAllMedicinesByPharmacyName("Neman")));

        System.out.println(Arrays.toString(dataBase.getAllSortedWorkersNameByPharmacyAddress("chuy 123")));

        System.out.println(dataBase.getPharmacyByWorkerName("Muha"));

        System.out.println(dataBase.addMedicinesToPharmacy("Neman",medicines3));

        System.out.println(pharmacy1.updateMedicinePrice("Парацетамол",60));

        System.out.println(pharmacy3.deleteMedicineByName("Аммоксоцилин"));

        System.out.println(pharmacy2.deleteWorkerByName("Nurtilek"));
        System.out.println(Arrays.toString(pharmacy2.workers));
    }
}