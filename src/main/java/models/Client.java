package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 顧客情報のDTOモデル
 */
@Table(name = JpaConst.TABLE_CLI)
@NamedQuery(
        name = JpaConst.Q_CLI_GET_ALL,
        query = JpaConst.Q_CLI_GET_ALL_DEF)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Client {

    /**
     * id
     */
    @Id
    @Column(name = JpaConst.CLI_COL_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 会社名
     */
    @Column(name = JpaConst.CLI_COL_COM, nullable = false)
    private String company;

    /**
     * 名前
     */
    @Column(name = JpaConst.CLI_COL_NAME, nullable = false)
    private String name;

    /**
     * メールアドレス
     */
    @Column(name = JpaConst.CLI_COL_MAIL, nullable = false)
    private String mail;

    /**
     * 電話番号
     */
    @Column(name = JpaConst.CLI_COL_TEL, nullable = false)
    private String telephone;
}
