FROM python:3.11-slim

COPY app/ /app/

WORKDIR /app

RUN pip install --no-cache-dir -r requirements.txt

EXPOSE 8000

CMD ["uvicorn", "--host", "0.0.0.0", "main:app"]


