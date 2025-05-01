package LLD3.ParkingLot.model;

import LLD3.ParkingLot.model.enums.GateStatus;
import LLD3.ParkingLot.model.enums.GateType;

public class Gate extends BaseModel {
    private int gateNumber;
    private GateType gateType;
    private GateStatus gateStatus;
    private String operator;

    public Gate() {
    }

    public Gate(int gateNumber, GateType gateType, GateStatus gateStatus, String operator) {
        this.gateNumber = gateNumber;
        this.gateType = gateType;
        this.gateStatus = gateStatus;
        this.operator = operator;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
