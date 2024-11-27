package item_17;

public final class Complex {

    private final double rp;
    private final double ip;

    public Complex(double rp, double ip) {
        this.rp = rp;
        this.ip = ip;
    }

    public double getRp() {
        return rp;
    }

    public double getIp() {
        return ip;
    }

    public Complex plus(Complex cx) {
        return new Complex(rp + cx.rp, ip + cx.ip);
    }

    public Complex minus(Complex cx) {
        return new Complex(rp - cx.rp, ip - cx.ip);
    }

    public Complex times(Complex cx) {
        return new Complex(
          rp * cx.rp - ip * cx.ip,
          rp * cx.ip + ip * cx.rp
        );
    }

    public Complex dividedBy(Complex cx) {
        double val = cx.rp * cx.rp + cx.ip * cx.ip;

        return new Complex(
          (rp * cx.rp + ip * cx.ip) / val,
          (ip * cx.rp - rp * cx.ip) / val
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Complex cx)) return false;

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







