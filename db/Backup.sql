USE [SimpleBlog]
GO
INSERT [dbo].[Users] ([email], [name], [password], [role], [status]) VALUES (N'admin@gmail.com', N'Admin', N'admin', N'admin', 1)
INSERT [dbo].[Users] ([email], [name], [password], [role], [status]) VALUES (N'user@gmail.com', N'User', N'user', N'user', 1)
INSERT [dbo].[Users] ([email], [name], [password], [role], [status]) VALUES (N'user1@a.com', N'User1', N'user', N'user', 1)
