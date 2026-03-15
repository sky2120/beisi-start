# 登录系统 API 文档

## 1. 接口描述

用户登录接口，验证用户名和密码，返回登录状态及模拟 Token。

## 2. 请求接口

- **URL**：`/api/login`
- **请求方式**：POST
- **请求参数类型**：application/json

## 3. 请求参数

| 参数名 | 类型 | 是否必填 | 说明 |
| :--- | :--- | :--- | :--- |
| username | string | 是 | 用户名 |
| password | string | 是 | 密码 |

## 4. 请求示例

```json
{
  "username": "admin",
  "password": "123456"
}
```

## 5. 响应结果

### 5.1 成功响应（账号密码正确）

- **HTTP 状态码**：200

```json
{
  "code": 0,
  "message": "Login successful",
  "data": {
    "token": "6066dee5-4f11-4919-955d-b975528fec5d"
  }
}
```

### 5.2 失败响应（账号密码错误）

- **HTTP 状态码**：200

```json
{
  "code": 1,
  "message": "Invalid username or password",
  "data": null
}
```

## 6. 字段说明

### 6.1 成功响应字段

| 字段名 | 类型 | 说明 |
| :--- | :--- | :--- |
| code | int | 0 表示成功 |
| message | string | 提示信息 |
| data.token | string | 登录成功后的模拟 Token |

### 6.2 失败响应字段

| 字段名 | 类型 | 说明 |
| :--- | :--- | :--- |
| code | int | 1 表示失败 |
| message | string | 错误提示信息 |
| data | null | 登录失败无返回数据 |

## 7. 注意事项

- 本接口仅用于模拟登录，返回的 Token 为随机生成的 UUID，不具备实际的鉴权功能
- 用户名和密码为硬编码，正确值为：`admin`/`123456`
- 接口支持跨域请求，已配置 CORS 头
- 接口返回数据格式为统一的 JSON 结构，便于前端处理