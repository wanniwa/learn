package 数组;

import com.alibaba.fastjson.JSON;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.function.Predicate;
@Data
@Builder
public class DependencyEntity<T> {

    private T node;

    private List<T> dependencyNodeList;

    /**
     * node被依赖的节点
     */
    private List<DependencyEntity<T>> parent;

    /**
     * node需要依赖的节点
     */
    private List<DependencyEntity<T>> children;

    // inner element

    private Boolean validate;

    private Predicate<T> predicate;

    // finally result

    private Byte result;

    public boolean isLeaf() {
        return CollectionUtils.isEmpty(dependencyNodeList);
    }

    public int getOrder() {
        if (CollectionUtils.isEmpty(parent)) {
            return 1;
        }
        int sum = 0;
        for (DependencyEntity entity : parent) {
            sum += entity.getOrder() + entity.getDependencyNodeList().size();
        }
        return sum;
    }

    public boolean validateDependency(Predicate<T> predicate) {
        if (CollectionUtils.containsAny(parent, children)) {
            System.out.println("【税务】-【取数】-【检查取数依赖】存在循环依赖配置！节点：{}" + JSON.toJSONString(node));
            throw new RuntimeException("存在取数依赖循环，请检查取数依赖配置！");
        }
        if (validate != null && predicate == this.predicate) {
            return validate;
        }
        this.predicate = predicate;
        if (isLeaf()) {
            return validate = predicate.test(node);
        }
        boolean validateChildren = children.stream().allMatch(target -> target.validateDependency(predicate));
        if (!validateChildren) {
            return false;
        }
        return this.validate = predicate.test(node);
    }

    public void setResult(Byte result) {
        this.result = result;
    }

}
