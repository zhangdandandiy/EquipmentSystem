/*
 * @Author: Dandan
 * @Date: 2023-05-12 11:17:20
 */

const definedTitle = '';
const title = definedTitle || 'Vue Admin Template'

/**
 * 设置页面标题
 * 
 * @param {*} pageTitle 
 * @returns 
 */
export default function getPageTitle(pageTitle) {
  if (pageTitle) {
    return `${pageTitle} - ${title}`
  }
  return `${title}`
}
