package 数组;

import java.util.List;

public class TaskNode {
    public List<TaskNode> getLeftList() {
        return leftList;
    }

    public void setLeftList(List<TaskNode> leftList) {
        this.leftList = leftList;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    public List<TaskNode> getRightList() {
        return rightList;
    }

    public void setRightList(List<TaskNode> rightList) {
        this.rightList = rightList;
    }

    private List<TaskNode> leftList;
    private Long data;
    private List<TaskNode> rightList;

    public TaskNode(Long data) {
        this.data = data;
    }
}
