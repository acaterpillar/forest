package com.rymcu.vertical.mapper;

import com.rymcu.vertical.core.mapper.Mapper;
import com.rymcu.vertical.dto.ArticleDTO;
import com.rymcu.vertical.dto.ArticleTagDTO;
import com.rymcu.vertical.dto.Author;
import com.rymcu.vertical.entity.Article;
import com.rymcu.vertical.entity.ArticleContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ronger
 */
public interface ArticleMapper extends Mapper<Article> {

    /**
     * 获取文章列表
     * @param searchText
     * @param tag
     * @return
     */
    List<ArticleDTO> selectArticles(@Param("searchText") String searchText, @Param("tag") String tag);

    /**
     * 根据用户 ID 获取作者信息
     * @param id
     * @return
     */
    Author selectAuthor(@Param("id") Integer id);

    /**
     * 根据文章 ID 查询文章
     * @param id
     * @return
     */
    ArticleDTO selectArticleDTOById(@Param("id") Integer id);

    /**
     * 保存文章内容
     * @param idArticle
     * @param articleContent
     * @param articleContentHtml
     * @return
     */
    Integer insertArticleContent(@Param("idArticle") Integer idArticle, @Param("articleContent") String articleContent, @Param("articleContentHtml") String articleContentHtml);

    /**
     * 更新文章内容
     * @param idArticle
     * @param articleContent
     * @param articleContentHtml
     * @return
     */
    Integer updateArticleContent(@Param("idArticle") Integer idArticle, @Param("articleContent") String articleContent, @Param("articleContentHtml") String articleContentHtml);

    /**
     * 获取文章正文内容
     * @param idArticle
     * @return
     */
    ArticleContent selectArticleContent(@Param("idArticle") Integer idArticle);

    /**
     * 获取主题下文章列表
     * @param topicName
     * @return
     */
    List<ArticleDTO> selectArticlesByTopicUri(@Param("topicName") String topicName);

    /**
     * 获取标签下文章列表
     * @param tagName
     * @return
     */
    List<ArticleDTO> selectArticlesByTagName(@Param("tagName") String tagName);

    /**
     * 获取用户文章列表
     * @param idUser
     * @return
     */
    List<ArticleDTO> selectUserArticles(@Param("idUser") Integer idUser);

    /**
     * 删除文章标签
     * @param id
     * @return
     */
    Integer deleteTagArticle(@Param("id") Integer id);

    /**
     * 获取文章标签列表
     * @param idArticle
     * @return
     */
    List<ArticleTagDTO> selectTags(@Param("idArticle") Integer idArticle);

    /**
     * 更新文章浏览数
     * @param id
     * @param articleViewCount
     * @return
     */
    Integer updateArticleViewCount(@Param("id") Integer id, @Param("articleViewCount") Integer articleViewCount);

    /**
     * 获取草稿列表
     * @param idUser
     * @return
     */
    List<ArticleDTO> selectDrafts(@Param("idUser") Integer idUser);
}
