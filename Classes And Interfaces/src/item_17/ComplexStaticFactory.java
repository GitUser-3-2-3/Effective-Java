package item_17;

public class ComplexStaticFactory {

    private final double rp;
    private final double ip;

    // diff. (private)
    private ComplexStaticFactory(double rp, double ip) {
        this.rp = rp;
        this.ip = ip;
    }

    public static ComplexStaticFactory valueOf(double rp, double ip) {
        return new ComplexStaticFactory(rp, ip);
    }

    public double getRp() {
        return rp;
    }

    public double getIp() {
        return ip;
    }

    public ComplexStaticFactory plus(ComplexStaticFactory cx) {
        return new ComplexStaticFactory(rp + cx.rp, ip + cx.ip);
    }

    public ComplexStaticFactory minus(ComplexStaticFactory cx) {
        return new ComplexStaticFactory(rp - cx.rp, ip - cx.ip);
    }

    public ComplexStaticFactory times(ComplexStaticFactory cx) {
        return new ComplexStaticFactory(
          rp * cx.rp - ip * cx.ip,
          rp * cx.ip + ip * cx.rp
        );
    }

    public ComplexStaticFactory dividedBy(ComplexStaticFactory cx) {
        double val = cx.rp * cx.rp + cx.ip * cx.ip;

        return new ComplexStaticFactory(
          (rp * cx.rp + ip * cx.ip) / val,
          (ip * cx.rp - rp * cx.ip) / val
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ComplexStaticFactory cx)) return false;

        return Double.compare(cx.rp, rp) == 0 && Double.compare(cx.ip, ip) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(rp) + Double.hashCode(ip);
    }

    @Override
    public String toString() {
        return "{" + "rp=" + rp + ", ip=" + ip + '}';
    }
}







