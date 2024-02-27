/*
 * @Author: Dandan
 * @Date: 2023-05-12 11:17:20
 */

/**
 * 判断一个链接是否为外部链接
 * 
 * @param {string} path
 * @returns {Boolean}
 */
export function isExternal(path) {
  return /^(https?:|mailto:|tel:)/.test(path)
}

/**
 * 过滤掉特殊字符，去除首尾空格
 * 
 * @param {*} str 
 * @returns 
 */
export function validateStr(str) {
  var re = /^[0-9a-zA-Z\-]*$/;  //判断字符串是否为数字和字母和-     
  if (!re.test(str)) {
    return false;
  } else {
    return str.toUpperCase().trim();  //转换为大写
  }
}


/**
 * 校验用户名
 * 
 * @param {string} str
 * @returns {Boolean}
 */
export function validUsername(str) {
  const valid_map = ['admin', 'editor']
  return valid_map.indexOf(str.trim()) >= 0
}
