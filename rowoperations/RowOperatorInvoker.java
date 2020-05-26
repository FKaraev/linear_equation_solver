package rowoperations;

public class RowOperatorInvoker {
    RowOperations rowOperation;

    public void setRowOperation(RowOperations rowOperation) {
        this.rowOperation = rowOperation;
    }

    public void invokeOperation(){
        rowOperation.execute();
    }
}
