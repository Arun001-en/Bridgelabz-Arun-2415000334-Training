import java.util.List;

abstract class JobRole {}
class SoftwareEngineer extends JobRole {}
class DataScientist extends JobRole {}
class ProductManager extends JobRole {}

class Resume<T extends JobRole> {
    T role;
    Resume(T r){ role=r; }
}

class Screening {
    static void process(List<? extends JobRole> list){
        for(JobRole j:list) System.out.println(j);
    }
}