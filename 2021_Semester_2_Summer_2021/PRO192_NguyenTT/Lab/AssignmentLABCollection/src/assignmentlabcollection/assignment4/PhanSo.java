package assignmentlabcollection.assignment4;

public class PhanSo implements Comparable<PhanSo>{
    private int tuSo;
    private int mauSo;

    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }

    @Override
    public String toString() {
        return tuSo+"/"+mauSo;
    }



    @Override
    public int compareTo(PhanSo o) {
        double thisRealValue = (double)tuSo/(double)mauSo;
        double oRealValue = (double)o.tuSo/(double)o.mauSo;
        if(thisRealValue < oRealValue){
            return -1;
        }else if(thisRealValue > oRealValue){
            return 1;
        }
        return 0;
    }
}