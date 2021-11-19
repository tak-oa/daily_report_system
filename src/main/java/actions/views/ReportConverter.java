package actions.views;

import java.util.ArrayList;
import java.util.List;

import constants.AttributeConst;
import constants.JpaConst;
import models.Report;

/**
 * 日報データのDTOモデル⇔Viewモデルの変換を行うクラス
 *
 */
public class ReportConverter {

    /**
     * ViewモデルのインスタンスからDTOモデルのインスタンスを作成する
     * @param rv ReportViewのインスタンス
     * @return Reportのインスタンス
     */
    public static Report toModel(ReportView rv) {
        return new Report(
                rv.getId(),
                EmployeeConverter.toModel(rv.getEmployee()),
                rv.getReportDate(),
                rv.getTitle(),
                rv.getContent(),
                rv.getCompany(),
                rv.getClient(),
                rv.getMail(),
                rv.getTelephone(),
                rv.getStatus(),
                rv.getCreatedAt(),
                rv.getUpdatedAt(),
                rv.getApprovalsFlag() == null
                        ? null
                        : rv.getApprovalsFlag() == AttributeConst.APP_FLAG_TRUE.getIntegerValue()
                                ? JpaConst.APP_FLAG_TRUE
                                : JpaConst.APP_FLAG_FALSE);
    }

    /**
     * DTOモデルのインスタンスからViewモデルのインスタンスを作成する
     * @param r Reportのインスタンス
     * @return ReportViewのインスタンス
     */
    public static ReportView toView(Report r) {

        if (r == null) {
            return null;
        }

        return new ReportView(
                r.getId(),
                EmployeeConverter.toView(r.getEmployee()),
                r.getReportDate(),
                r.getTitle(),
                r.getContent(),
                r.getCompany(),
                r.getClient(),
                r.getMail(),
                r.getTelephone(),
                r.getStatus(),
                r.getCreatedAt(),
                r.getUpdatedAt(),
                r.getApprovalsFlag() == null
                        ? null
                        : r.getApprovalsFlag() == AttributeConst.APP_FLAG_TRUE.getIntegerValue()
                                ? JpaConst.APP_FLAG_TRUE
                                : JpaConst.APP_FLAG_FALSE);
    }

    /**
     * DTOモデルのリストからViewモデルのリストを作成する
     * @param list DTOモデルのリスト
     * @return Viewモデルのリスト
     */
    public static List<ReportView> toViewList(List<Report> list) {
        List<ReportView> evs = new ArrayList<>();

        for (Report r : list) {
            evs.add(toView(r));
        }

        return evs;
    }

    /**
     * Viewモデルの全フィールドの内容をDTOモデルのフィールドにコピーする
     * @param r DTOモデル(コピー先)
     * @param rv Viewモデル(コピー元)
     */
    public static void copyViewToModel(Report r, ReportView rv) {
        r.setId(rv.getId());
        r.setEmployee(EmployeeConverter.toModel(rv.getEmployee()));
        r.setReportDate(rv.getReportDate());
        r.setTitle(rv.getTitle());
        r.setContent(rv.getContent());
        r.setCompany(rv.getCompany());
        r.setClient(rv.getClient());
        r.setMail(rv.getMail());
        r.setTelephone(rv.getTelephone());
        r.setStatus(rv.getStatus());
        r.setCreatedAt(rv.getCreatedAt());
        r.setUpdatedAt(rv.getUpdatedAt());
        r.setApprovalsFlag(rv.getApprovalsFlag());
    }

    /**
     * DTOモデルの全フィールドの内容をViewモデルのフィールドにコピーする
     * @param r DTOモデル(コピー元)
     * @param rv Viewモデル(コピー先)
     */
    public static void copyModelToView(Report r, ReportView rv) {
        rv.setId(r.getId());
        rv.setEmployee(EmployeeConverter.toView(r.getEmployee()));
        rv.setReportDate(r.getReportDate());
        rv.setTitle(r.getTitle());
        rv.setCreatedAt(r.getCreatedAt());
        rv.setUpdatedAt(r.getUpdatedAt());
    }

}
