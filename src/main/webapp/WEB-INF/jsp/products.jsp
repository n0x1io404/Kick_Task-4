<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang != null ? sessionScope.lang : 'en'}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="app_title"/></title>
    <!-- Add Tailwind via CDN for simplicity since it's JSP -->
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        body { font-family: 'Inter', sans-serif; background-color: #fcf9f5; color: #2c2420; }
        .font-serif { font-family: 'Playfair Display', serif; }
    </style>
</head>
<body>
    <header class="bg-white border-b border-[#e8dfd5] px-6 py-5 flex justify-between items-center sticky top-0 z-10">
        <div class="flex flex-col">
            <h1 class="text-2xl font-serif text-[#4a3b32] tracking-wide"><fmt:message key="app_title"/></h1>
            <span class="text-xs tracking-widest uppercase text-[#887063] mt-0.5"><fmt:message key="subtitle"/></span>
        </div>
        <div class="flex space-x-6 items-center">
            <c:if test="${not empty sessionScope.user}">
                <span class="text-sm text-[#5f4b41]"><fmt:message key="welcome"/>, <strong class="font-serif italic text-base">${sessionScope.user.username}</strong></span>
                <a href="${pageContext.request.contextPath}/controller?command=logout" class="text-sm bg-transparent border border-[#d6c9be] text-[#5f4b41] hover:bg-[#e8dfd5] px-4 py-1.5 rounded-full transition"><fmt:message key="logout"/></a>
            </c:if>
            <c:if test="${empty sessionScope.user}">
                <a href="${pageContext.request.contextPath}/controller?command=login" class="text-sm bg-transparent border border-[#d6c9be] text-[#5f4b41] hover:bg-[#e8dfd5] px-4 py-1.5 rounded-full transition"><fmt:message key="login"/></a>
            </c:if>
        </div>
    </header>

    <main class="max-w-6xl mx-auto p-8 grid grid-cols-1 md:grid-cols-3 gap-12">
        <div class="space-y-12 md:col-span-2">
            <section>
                <h2 class="text-2xl font-serif mb-6 text-[#4a3b32]"><fmt:message key="products"/></h2>
                <div class="grid grid-cols-1 sm:grid-cols-2 gap-6">
                    <c:forEach var="p" items="${products}">
                        <div class="bg-white border border-[#e8dfd5] p-6 rounded-lg shadow-sm hover:shadow-md transition group flex flex-col justify-between">
                            <div>
                                <h3 class="font-serif text-xl text-[#3b2f28] group-hover:text-[#a06a4b] transition">${p.name}</h3>
                                <p class="text-sm text-[#7a6558] mt-3 leading-relaxed min-h-[60px]">${p.description}</p>
                            </div>
                            <div class="mt-6 pt-4 border-t border-[#f4eee8] flex justify-between items-center">
                                <span class="font-sans text-[#a06a4b] font-medium tracking-wide">$${p.price}</span>
                                <a href="${pageContext.request.contextPath}/controller?command=make_order&id=${p.id}"
                                   class="bg-[#4a3b32] hover:bg-[#2c2420] text-white text-xs px-4 py-2 uppercase tracking-widest rounded transition text-center">
                                    <fmt:message key="order_button"/>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </section>
        </div>
    </main>
</body>
</html>
