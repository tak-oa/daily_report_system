package actions.views;

import java.util.ArrayList;
import java.util.List;

import constants.AttributeConst;
import constants.JpaConst;
import models.Employee;

/**
 * 従業員データのDTOモデル⇔Viewモデルの変換を行うクラス
 *
 */
public class EmployeeConverter {

    /**
     * ViewモデルのインスタンスからDTOモデルのインスタンスを作成
     * @param ev EmployeeViewsのインスタンス
     * @return Employeeのインスタンス
     */
    public static Employee toModel(EmployeeView ev) {

        return new Employee(
                ev.getId(),
                ev.getCode(),
                ev.getName(),
                ev.getPassword(),
                ev.getAdminFlag() == null
                        ? null
                        : ev.getAdminFlag() == AttributeConst.ROLE_ADMIN.getIntegerValue()
                            ? JpaConst.ROLE_ADMIN
                            : JpaConst.ROLE_GENERAL,
                ev.getApprovalFlag() == null
                        ? null
                        : ev.getApprovalFlag() == AttributeConst.ROLE_DIRECTOR.getIntegerValue()
                            ? JpaConst.ROLE_DIRECTOR
                            : ev.getApprovalFlag() == AttributeConst.ROLE_MANAGER.getIntegerValue()
                                ? JpaConst.ROLE_MANAGER
                                : JpaConst.ROLE_GENERALS,
                ev.getCreatedAt(),
                ev.getUpdatedAt(),
                ev.getDeleteFlag() == null
                        ? null
                        : ev.getDeleteFlag() == AttributeConst.DEL_FLAG_TRUE.getIntegerValue()
                                ? JpaConst.EMP_DEL_TRUE
                                : JpaConst.EMP_DEL_FALSE);
    }

    /**
     * DTOモデルのインスタンスからViewモデルのインスタンスを作成
     * @param e Employeeのインスタンス
     * @return EmployeeViewのインスタンス
     */
    public static EmployeeView toView(Employee e) {

        if(e == null) {
            return null;
        }

        return new EmployeeView(
                e.getId(),
                e.getCode(),
                e.getName(),
                e.getPassword(),
                e.getAdminFlag() == null
                        ? null
                        : e.getAdminFlag() == AttributeConst.ROLE_ADMIN.getIntegerValue()
                            ? JpaConst.ROLE_ADMIN
                            : JpaConst.ROLE_GENERAL,
                e.getApprovalFlag() == null
                        ? null
                        : e.getApprovalFlag() == AttributeConst.ROLE_DIRECTOR.getIntegerValue()
                            ? JpaConst.ROLE_DIRECTOR
                            : e.getApprovalFlag() == AttributeConst.ROLE_MANAGER.getIntegerValue()
                                ? JpaConst.ROLE_MANAGER
                                : JpaConst.ROLE_GENERALS,
                e.getCreatedAt(),
                e.getUpdatedAt(),
                e.getDeleteFlag() == null
                        ? null
                        : e.getDeleteFlag() == JpaConst.EMP_DEL_TRUE
                                ? AttributeConst.DEL_FLAG_TRUE.getIntegerValue()
                                : AttributeConst.DEL_FLAG_FALSE.getIntegerValue());
    }

    /**
     * DTOモデルのリストからViewsモデルのリストを作成
     * @param list DTOモデルのリスト
     * @return Viewsモデルのリスト
     */
    public static List<EmployeeView> toViewList(List<Employee> list) {
        List<EmployeeView> evs = new ArrayList<>();

        for (Employee e : list) {
            evs.add(toView(e));
        }

        return evs;
    }

    /**
     * Viewsモデルの全フィールドの内容をDTOモデルのフィールドにコピーする
     * @param e DTOモデル(コピー先)
     * @param ev Viewモデル(コピー先)
     */
    public static void copyViewsToModel(Employee e, EmployeeView ev) {
        e.setId(ev.getId());
        e.setCode(ev.getCode());
        e.setName(ev.getName());
        e.setPassword(ev.getPassword());
        e.setAdminFlag(ev.getAdminFlag());
        e.setApprovalFlag(ev.getApprovalFlag());
        e.setCreatedAt(ev.getCreatedAt());
        e.setUpdatedAt(ev.getUpdatedAt());
        e.setDeleteFlag(ev.getDeleteFlag());
    }
}
