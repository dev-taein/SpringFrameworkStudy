package com.spring.mybatis02.modelEx;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.spring.mybatis02.modelEx.MybatisMember;
import com.spring.mybatis02.modelEx.MybatisMemberExample;

public interface MybatisMemberMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HR.MYBATIS_MEMBER
     *
     * @mbg.generated Fri May 21 16:46:37 KST 2021
     */
    long countByExample(MybatisMemberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HR.MYBATIS_MEMBER
     *
     * @mbg.generated Fri May 21 16:46:37 KST 2021
     */
    int deleteByExample(MybatisMemberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HR.MYBATIS_MEMBER
     *
     * @mbg.generated Fri May 21 16:46:37 KST 2021
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HR.MYBATIS_MEMBER
     *
     * @mbg.generated Fri May 21 16:46:37 KST 2021
     */
    int insert(MybatisMember record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HR.MYBATIS_MEMBER
     *
     * @mbg.generated Fri May 21 16:46:37 KST 2021
     */
    int insertSelective(MybatisMember record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HR.MYBATIS_MEMBER
     *
     * @mbg.generated Fri May 21 16:46:37 KST 2021
     */
    List<MybatisMember> selectByExample(MybatisMemberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HR.MYBATIS_MEMBER
     *
     * @mbg.generated Fri May 21 16:46:37 KST 2021
     */
    MybatisMember selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HR.MYBATIS_MEMBER
     *
     * @mbg.generated Fri May 21 16:46:37 KST 2021
     */
    int updateByExampleSelective(@Param("record") MybatisMember record, @Param("example") MybatisMemberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HR.MYBATIS_MEMBER
     *
     * @mbg.generated Fri May 21 16:46:37 KST 2021
     */
    int updateByExample(@Param("record") MybatisMember record, @Param("example") MybatisMemberExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HR.MYBATIS_MEMBER
     *
     * @mbg.generated Fri May 21 16:46:37 KST 2021
     */
    int updateByPrimaryKeySelective(MybatisMember record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HR.MYBATIS_MEMBER
     *
     * @mbg.generated Fri May 21 16:46:37 KST 2021
     */
    int updateByPrimaryKey(MybatisMember record);
}